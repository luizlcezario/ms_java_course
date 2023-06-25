package schedules

import (
	"encoding/json"
	"log"
	"net/http"

	"banks.turing.itau.com.br/src/models"
)

func Findbanks() {
	// Coloque aqui a lógica da sua tarefa cronometrada
	response, _ := http.Get("https://brasilapi.com.br/api/banks/v1")
	if err := json.NewDecoder(response.Body).Decode(&models.BanksApi); err != nil {
		log.Fatal("ooopsss! an error occurred, please try again")
	}

}
