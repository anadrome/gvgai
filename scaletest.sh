#!/bin/sh
# Test MCTS scaling curves on VGDL games.
# mjn, 4/2016

# Usage:
#   ./scaletest.sh N
# where N is a per-turn time limit in milliseconds

ITER=5
GAMES=`find examples/gridphysics -type f -not -name "*_lvl?.txt" -exec basename {} .txt \; | sort`

for g in $GAMES
do
    java -Xmx500m -cp dist/gvgai.jar ScaleTest $g $1 $ITER
done
