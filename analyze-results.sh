#!/bin/bash
if [ $# -ne 1 ]; then
  echo "usage ${0} <results-file>";
  exit 1;
fi
file=$1
i=0;
DEFAULT_SUM=0;
LINEAR_SUM=0;
while read line; do
  if [ ${line:0:1} != "#" ]; then
    if [ $((i%2)) -eq 0 ]; then
      DEFAULT_SUM=$((DEFAULT_SUM + line));
    else
      LINEAR_SUM=$((LINEAR_SUM + line));
    fi
    i=$((i + 1))
  fi
done < $1
i=$((1000*i/2))
echo "DEFAULT STRATEGY AVERAGE: "$((DEFAULT_SUM/i))" micro seconds"
echo "LINEAR STRATEGY AVERAGE: "$((LINEAR_SUM/i))" micro seconds"
