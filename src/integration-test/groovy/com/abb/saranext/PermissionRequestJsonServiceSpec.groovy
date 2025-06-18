package com.abb.saranext

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PermissionRequestJsonServiceSpec extends Specification {

    PermissionRequestJsonService permissionRequestJsonService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PermissionRequestJson(...).save(flush: true, failOnError: true)
        //new PermissionRequestJson(...).save(flush: true, failOnError: true)
        //PermissionRequestJson permissionRequestJson = new PermissionRequestJson(...).save(flush: true, failOnError: true)
        //new PermissionRequestJson(...).save(flush: true, failOnError: true)
        //new PermissionRequestJson(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //permissionRequestJson.id
    }

    void "test get"() {
        setupData()

        expect:
        permissionRequestJsonService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PermissionRequestJson> permissionRequestJsonList = permissionRequestJsonService.list(max: 2, offset: 2)

        then:
        permissionRequestJsonList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        permissionRequestJsonService.count() == 5
    }

    void "test delete"() {
        Long permissionRequestJsonId = setupData()

        expect:
        permissionRequestJsonService.count() == 5

        when:
        permissionRequestJsonService.delete(permissionRequestJsonId)
        sessionFactory.currentSession.flush()

        then:
        permissionRequestJsonService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PermissionRequestJson permissionRequestJson = new PermissionRequestJson()
        permissionRequestJsonService.save(permissionRequestJson)

        then:
        permissionRequestJson.id != null
    }
}
