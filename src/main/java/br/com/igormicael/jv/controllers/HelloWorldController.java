package br.com.igormicael.jv.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class HelloWorldController
{

   private String name;
   private String label;

   public void action()
   {
      System.out.println("button clicked!");
      label = "Hello " + name;
   }

   public String getLabel()
   {
      return label;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }
}