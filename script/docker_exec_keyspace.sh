cd $(dirname $0)
docker exec -i 12db cqlsh -e "CREATE KEYSPACE \"mike\" WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};"