package com.app.gest.immo.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("100")
public class Quartier extends Parametre{

}
