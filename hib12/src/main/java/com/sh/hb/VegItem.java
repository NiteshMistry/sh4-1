package com.sh.hb;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Veg")
public class VegItem extends Item {
	// veg specific fields (if any)
}
