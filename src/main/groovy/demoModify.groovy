import org.apache.directory.groovyldap.LDAP

ldap = LDAP.newInstance('ldap://zanzibar:10389', 'uid=admin,ou=system' ,'secret')

dn = 'cn=Heather Nova,dc=example,dc=com'

// Adding a single attribute
//
descr = [ description: 'a singer-songwriter' ]
ldap.modify(dn, 'ADD', descr)

// performing two operations atomically
//
mods = [ 
    [ 'REPLACE', [description: 'a singer-songwriter, born in Bermuda'] ],
    [ 'ADD', [userPassword: 'secret'] ]
]
ldap.modify(dn, mods)
