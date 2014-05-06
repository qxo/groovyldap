import org.apache.directory.groovyldap.LDAP

ldap = LDAP.newInstance('ldap://zanzibar:10389', 'uid=admin,ou=system' ,'secret')

// assert ldap.exists('cn=Heather Nova,dc=example,dc=com')

// delete the entry with the given DN
ldap.delete('cn=Heather Nova,dc=example,dc=com')

assert !ldap.exists('cn=Heather Nova,dc=example,dc=com')