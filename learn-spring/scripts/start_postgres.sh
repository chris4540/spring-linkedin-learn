#!/usr/bin/env bash

#       Script doc
# You need to install the client of the PostgreSQL first.
#
# macOS:
# > brew install libpg

set -euo pipefail
which psql > /dev/null || (echo "Please ensure that postgres client is in your PATH" && exit 1)

mkdir -p $HOME/docker/volumes/postgres
rm -rf $HOME/docker/volumes/postgres/data

docker run --rm --name pg-docker -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=dev -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql postgres
sleep 3
export PGPASSWORD=postgres
export SQL_DIRECTORY=../src/main/resources
psql -U postgres -d dev -h localhost -f $SQL_DIRECTORY/schema.sql
psql -U postgres -d dev -h localhost -f $SQL_DIRECTORY/data.sql
