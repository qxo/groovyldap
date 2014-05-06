import org.apache.directory.groovyldap.*

ldap = LDAP.newInstance('ldap://zanzibar:10389/')

results = ldap.search('(objectClass=person)', 'dc=example,dc=com', SearchScope.ONE)
println " ${results.size} entries found ".center(40,'-')
for (entry in results) {
  println entry.dn
}

println ""

results = ldap.search(filter: '(objectClass=person)', base: 'dc=example,dc=com', scope: 'ONE')
println " ${results.size} entries found ".center(40,'-')
for (entry in results) {
  println entry.dn
}

println ""

def params = new Search()
params.filter='(objectClass=person)'
params.base='dc=example,dc=com'
params.scope=SearchScope.ONE

results = ldap.search(params)
println " ${results.size} entries found ".center(40,'-')
for (entry in results) {
  println entry.dn
}