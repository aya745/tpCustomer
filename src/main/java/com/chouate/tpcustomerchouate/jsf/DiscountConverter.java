/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chouate.tpcustomerchouate.jsf;

/**
 *
 * @author tech
 */
import com.chouate.tpcustomerchouate.service.DiscountManager;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import com.chouate.tpcustomerchouate.entity.Discount;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;



/**
 * Backing bean pour la page customerDetails.xhtml.
 */
@FacesConverter(value = "discountConverter", managed=true)
public class DiscountConverter implements Converter<Discount> {

    /**
     *
     */
    @Inject
  private DiscountManager discountManager;

  /**
   * Convertit une String en Discount.
   *
     * @param context
     * @param component
   * @param value valeur à convertir
     * @return 
   */
  public Discount getAsObject(FacesContext context, UIComponent component, String value) {
    if (value == null) return null;
    return discountManager.findById(value);
  }

  /**
   * Convertit un Discount en String.
   *
     * @param context
     * @param component
     * @param discount
     * @return 
   */
  @Override
  public String getAsString(FacesContext context, UIComponent component, Discount discount) {
    if (discount == null) return "";
    return discount.getCode();
  }
}
