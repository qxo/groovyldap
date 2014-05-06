import org.apache.directory.groovyldap.LDAP

ldap = LDAP.newInstance('ldap://zanzibar:10389', 'uid=admin,ou=system' ,'secret')

assert ! ldap.exists('cn=Heather Nova,dc=example,dc=com')

// define the attributes as a map
attrs = [
  objectclass: ['top', 'person'],              
  sn: 'Nova',
  cn: 'Heather Nova'
]
ldap.add('cn=Heather Nova,dc=example,dc=com', attrs)

assert ldap.exists('cn=Heather Nova,dc=example,dc=com')