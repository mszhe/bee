package controllers

import "github.com/astaxie/beego"

type ErrorController struct {
	beego.Controller
}

func (c *ErrorController) Error401() {
	c.Err4x()
}

func (c *ErrorController) Error402() {
	c.Err4x()
}

func (c *ErrorController) Error403() {
	c.Err4x()
}

func (c *ErrorController) Error404() {
	c.Err4x()
}

func (c *ErrorController) Error417() {
	c.Err4x()
}

func (c *ErrorController) Error422() {
	c.Err4x()
}

func (c *ErrorController) Err4x()  {
	c.Data["json"] = ErrStr("找不到接口")
	c.ServeJSON()
}

func (c *ErrorController) Error500() {
	c.Err5x()
}

func (c *ErrorController) Error501() {
	c.Err5x()
}

func (c *ErrorController) Error502() {
	c.Err5x()
}

func (c *ErrorController) Error503() {
	c.Err5x()
}

func (c *ErrorController) Error504() {
	c.Err5x()
}

func (c *ErrorController) ErrorDb() {
	c.Err5x()
}

func (c *ErrorController) Err5x()  {
	c.Data["json"] = ErrInternal()
	c.ServeJSON()
}
