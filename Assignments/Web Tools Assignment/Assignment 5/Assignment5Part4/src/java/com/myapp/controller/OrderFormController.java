/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.controller;

import com.myapp.DAO.SalesDAO;
import configuration.Salesordernew;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author hpanjwani
 */
public class OrderFormController extends SimpleFormController {
    
    private SalesDAO salesDAO;
    
    public OrderFormController(SalesDAO salesDAO) {
        setCommandClass(Salesordernew.class);
        setCommandName("sales");
        this.salesDAO=salesDAO;

    }

    @Override
    protected void doSubmitAction(Object command) throws Exception {
        Salesordernew s=(Salesordernew)command;
        System.out.println("here");
        System.out.println(s.getSalesOrderId());
        salesDAO.addToDatabase(s);
    }

    
}
