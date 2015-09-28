#!/bin/bash
if [ $# -ne 2 ];
then
  echo "Usage ${0} <number-of-runs> <output-file>";
  exit 1;
fi
for i in $(eval echo {1..$1}); do
  echo "#Test "$i >> $2;
  java -jar target/replace-placeholders-1.0-SNAPSHOT.jar >> $2;
done
