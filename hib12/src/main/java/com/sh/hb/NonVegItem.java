package com.sh.hb;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="NonVeg")
public class NonVegItem extends Item {
	// non-veg specific fields (if any)
}
