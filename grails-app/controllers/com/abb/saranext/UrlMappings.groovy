package com.abb.saranext

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/rest/integration/fcm/requests/next"(controller: "permissionRequest", action: "next")

        "/rest/integration/fcm/requests/confirmation/$id"(controller: "permissionRequest", action: "confirmation")

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
