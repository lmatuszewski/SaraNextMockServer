package com.abb.saranext

class PermissionRequestJson {

    Long id
    String json

    static constraints = {
        json(type:"text", widget: "textarea")
    }
}
