package com.app.gest.immo.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("101")
public class Ville extends Parametre{

}
