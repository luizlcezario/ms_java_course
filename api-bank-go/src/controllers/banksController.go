package controllers

import (
	"encoding/json"
	"net/http"

	"banks.turing.itau.com.br/src/models"
)

func Home(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	json.NewEncoder(w).Encode(models.BanksApi)
}
