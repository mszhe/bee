package controllers

import "strings"

type Output struct {
	Ret     int `json:"ret"`          // 0-ok, 1-internal err, 2-param err, 3-auth err
	Errcode int `json:"errcode"`      // detail err code
	Msg     string `json:"msg"`       // msg
	Data    interface{} `json:"data"` // data
}

func Ok(data interface{}) *Output {
	return &Output{Ret: 0, Errcode: 200, Msg: "OK", Data: data}
}

func OkStr() *Output {
	return &Output{Ret: 0, Errcode: 200, Msg: "OK"}
}

func Err(err error) *Output {
	return &Output{Ret: 1, Errcode: 500, Msg: err.Error()}
}

func ErrInternal() *Output {
	return &Output{Ret: 1, Errcode: 500, Msg: "internal err"}
}

func ErrStr(err string) *Output {
	return &Output{Ret: 1, Errcode: 500, Msg: err}
}

func Wrap(data interface{}, err error) *Output {
	if err == nil {
		return Ok(data)
	} else {
		return Err(err)
	}
}

func WrapStr(data interface{}, err string) *Output {
	if 0 == len(err) || 0 == len(strings.TrimSpace(err)) {
		return Ok(data)
	} else {
		return ErrStr(err)
	}
}
