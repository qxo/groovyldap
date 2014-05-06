import org.apache.directory.groovyldap.*

ldap = LDAP.newInstance('ldap://zanzibar:10389', 'uid=admin,ou=system' ,'secret')

ldap.eachEntry(base:'dc=example,dc=com', filter:'(objectClass=person)', scope:'ONE') { entry ->
    ldap.delete(entry.dn)
}
