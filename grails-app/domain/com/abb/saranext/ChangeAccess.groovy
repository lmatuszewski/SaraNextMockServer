package com.abb.saranext

import groovy.transform.ToString

@ToString(includePackage = false, includeNames = true)
class ChangeAccess {

    Long id
    String productGroup
    String country
    String division

    static constraints = {
        productGroup(nullable: true, blank: true)
        country(nullable: true, blank: true)
        division(nullable: true, blank: true)
    }

    Map toMap() {
        ["Product Group": this.productGroup,
         "Country"      : this.country,
         "Division"     : this.division
        ]
    }
}
