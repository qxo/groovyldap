import org.apache.directory.groovyldap.LDAP

ldap = LDAP.newInstance('ldap://zanzibar:10389', 'uid=admin,ou=system' ,'secret')

assert ! ldap.exists('cn=Heather Nova,dc=example,dc=com')

// define an entry for compare ops
attrs = [
  objectclass: ['top', 'person'],              
  sn: 'Nova',
  cn: 'Heather Nova',
  userPassword: 'secret'
]
ldap.add('cn=Heather Nova,dc=example,dc=com', attrs)

assert ldap.exists('cn=Heather Nova,dc=example,dc=com')

assert ldap.compare('cn=Heather Nova,dc=example,dc=com', [cn: 'Heather Nova'] )
assert ldap.compare('cn=Heather Nova,dc=example,dc=com', [cn: 'HEATHER NOVA'] )

assert ldap.compare('cn=Heather Nova,dc=example,dc=com', [userPassword: 'secret'] )
assert ! ldap.compare('cn=Heather Nova,dc=example,dc=com', [userPassword: 'SECRET'] )

ldap.delete('cn=Heather Nova,dc=example,dc=com')