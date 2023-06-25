package routes

import (
	"net/http"

	"banks.turing.itau.com.br/src/controllers"
)

func HandleRequests() {
	http.HandleFunc("/banks", controllers.Home)
}
