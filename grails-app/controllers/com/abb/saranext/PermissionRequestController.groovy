package com.abb.saranext

import grails.converters.JSON

class PermissionRequestController {

    static scaffold = PermissionRequest

    def next() {
        println "next()"
        println "request = $request"
        println "params = $params"
        PermissionRequest r = PermissionRequest.findByProcessed(false)
        if (!r) {
            render(new Object() as JSON)
            return
        }
        r.processed = true
        r.save(flush:true)
        render(r.toMap() as JSON)
    }

    def confirmation(Long id) {
        println "confirmation() id: $id"
        PermissionRequest r = PermissionRequest.findByRequestId(id)
        println "r = $r"
        if (!r) {
            render(status: 404)
            return
        }
        r.confirmed = true
        r.save(flush:true)
        render(status: 200)
    }
}
