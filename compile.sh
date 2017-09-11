#!/bin/bash
mkdir -p bin
cp -r textanalyser/data bin
javac -d bin -sourcepath textanalyser/  textanalyser/**/*.java
