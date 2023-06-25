package models

type Bank struct {
	Code     int    `json:"code"`
	Name     string `json:"name"`
	Ispb     string `json:"ispb"`
	FullName string `json:"fullName"`
}

var BanksApi []Bank
