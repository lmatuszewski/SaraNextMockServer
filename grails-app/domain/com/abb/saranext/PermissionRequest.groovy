package com.abb.saranext

import groovy.transform.ToString

@ToString(includePackage = false, includeNames = true)
class PermissionRequest {

    Long id
    Integer requestId
    String requestType
    String userADAccount
    String roleName
    String userGEID
    String userPrincipalName
    String lineManagerEmail
    String approverEmail
    String approverPosition
    String secondApproverEmail
    String secondApproverPosition
    ChangeAccess previousAccess// = new ChangeAccess()
    ChangeAccess newAccess// = new ChangeAccess()

    boolean processed = false
    boolean confirmed = false

    static constraints = {
        requestId()
        requestType()
        userADAccount()
        roleName()
        userGEID()
        userPrincipalName()
        lineManagerEmail()
        approverEmail()
        approverPosition()
        secondApproverEmail()
        secondApproverPosition()
        previousAccess(nullable: true)
        newAccess(nullable: true)
    }

//    static embedded = ['previousAccess', 'newAccess']

    Map toMap() {
        [
            requestId: this.requestId,
            requestType: this.requestType,
            userADAccount: this.userADAccount,
            roleName: this.roleName,
            userGEID: this.userGEID,
            userPrincipalName: this.userPrincipalName,
            lineManagerEmail: this.lineManagerEmail,
            approverEmail: this.approverEmail,
            approverPosition: this.approverPosition,
            secondApproverEmail: this.secondApproverEmail,
            secondApproverPosition: this.secondApproverPosition,
            previousAccess: this.previousAccess?.toMap(),
            newAccess: this.newAccess?.toMap()
        ]
    }
}

enum RequestType {
    Create("Create"),
    Modify("Modify"),
    Replace("Replace"),
    Delete("Delete")
}
