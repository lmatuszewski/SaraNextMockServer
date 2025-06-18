package com.abb.saranext

import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import groovy.json.JsonSlurper
import org.grails.web.json.JSONElement

class PermissionRequestJsonController {

    static scaffold = PermissionRequestJson

    @Transactional
    def save(PermissionRequestJson permissionRequestJson) {
        println "{permissionRequestJson.json} = ${permissionRequestJson.json}"
        if (permissionRequestJson == null) {
            notFound()
            return
        }

        PermissionRequest permissionRequest = null
        try {
            permissionRequestJson.save(flush:true, failOnError:true)
            JSONElement json = JSON.parse(permissionRequestJson.json)
            println "json = $json"
            permissionRequest = new PermissionRequest(json)
            permissionRequest.save(flush:true, failOnError:true)

            def previousAccess = json.get("previousAccess")
            println "previousAccess = $previousAccess"
            if (previousAccess) {
                ChangeAccess newPreviousAccess = new ChangeAccess(
                        productGroup:previousAccess.get("Product Group"), country:previousAccess.get("Country"),
                        division: previousAccess.get("Division")
                ).save(flush:true, failOnError:true)
                println "newChangeAccess = $newPreviousAccess"
                permissionRequest.previousAccess = newPreviousAccess
                permissionRequest.save(flush:true, failOnError:true)
            }

            def newAccess = json.get("newAccess")
            println "newAccess = $newAccess"
            if (newAccess) {
                ChangeAccess newChangeAccess = new ChangeAccess(
                        productGroup:newAccess.get("Product Group"), country:newAccess.get("Country"),
                        division: newAccess.get("Division")
                ).save(flush:true, failOnError:true)
                println "newChangeAccess = $newChangeAccess"
                permissionRequest.newAccess = newChangeAccess
                permissionRequest.save(flush:true, failOnError:true)
            }

            println "permissionRequest = $permissionRequest"
        } catch (ValidationException e) {
            respond permissionRequest.errors, view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'PermissionRequestJson.label', default: 'permissionRequestJson'), permissionRequestJson.id])
                redirect action:"index", method:"GET"
            }
            '*' { respond permissionRequest, [status: CREATED] }
        }
    }
}
