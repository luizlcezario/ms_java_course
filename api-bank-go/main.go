package main

import (
	"fmt"
	"log"
	"net/http"
	"time"

	"banks.turing.itau.com.br/src/routes"
	"banks.turing.itau.com.br/src/schedules"
	"github.com/ArthurHlt/go-eureka-client/eureka"
)

func startScheduledTaskForfindBanks(interval time.Duration, funcToRun func()) {
	ticker := time.NewTicker(interval)
	funcToRun()
	for range ticker.C {
		funcToRun()

	}
}

func startEurekaClient() {
	time.Sleep(time.Second * 2)
	client, _ := eureka.NewClientFromFile("config.json")
	instance := eureka.NewInstanceInfo("localhost:8000", "banks-api", "127.0.0.1", 8000, 2, false) //Create a new instance to register
	instance.Metadata = &eureka.MetaData{
		Map: make(map[string]string),
	}
	instance.Metadata.Map["foo"] = "bar"
	e := client.RegisterInstance("banks-api", instance)
	if e != nil {
		fmt.Println(e)
	}
	fmt.Println("registered instance")
	time.Sleep(time.Second * 30)
	e2 := client.SendHeartbeat(instance.App, instance.HostName)
	if e2 != nil {
		fmt.Println(e2)
	}
	fmt.Println("send heartbeat")
}

func main() {

	go startScheduledTaskForfindBanks(time.Hour*24, schedules.Findbanks)
	go startEurekaClient()
	routes.HandleRequests()
	fmt.Println("Server is running on port 8000")
	log.Fatal(http.ListenAndServe(":8000", nil))
}
