package com.abb.saranext

import grails.gorm.services.Service

@Service(PermissionRequestJson)
interface PermissionRequestJsonService {

    PermissionRequestJson get(Serializable id)

    List<PermissionRequestJson> list(Map args)

    Long count()

    void delete(Serializable id)

    PermissionRequestJson save(PermissionRequestJson permissionRequestJson)

}