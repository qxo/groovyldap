import org.apache.directory.groovyldap.LDAP

ldap = LDAP.newInstance("ldap://zanzibar:10389")

// Simple entry lookup via dn
heather = ldap.read('cn=Heather Nova,dc=example,dc=com')

print """
DN: ${heather.dn}
Common name: ${heather.cn}
Object classes: ${heather.objectclass}
"""
