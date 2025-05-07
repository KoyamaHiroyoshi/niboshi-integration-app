#!/bin/bash

# スクリプトのディレクトリに移動する
SCRIPT_DIR=$(cd $(dirname $0);pwd)
cd $SCRIPT_DIR
pwd

# allure-resultsがなければ作成する
AGGREGATE_DIR="../../report-aggregator/target/allure-results"
if [ ! -d $AGGREGATE_DIR ];then
  echo "Not exist : $AGGREGATE_DIR."
  mkdir $AGGREGATE_DIR
else
  echo "Exist : $AGGREGATE_DIR."
fi

# domainsのallureレポートを収集する
if [ -d ../../domains/allure-results/ ];then
  echo move domains test files.
  mv ../../domains/allure-results/*.json $AGGREGATE_DIR/.
fi

# infrastructuresのallureレポートを収集する
if [ -d ../../infrastructures/allure-results/ ];then
  echo move infrastructures test files.
  mv ../../infrastructures/allure-results/*.json $AGGREGATE_DIR/.
fi

# applicationsのallureレポートを収集する
if [ -d ../../applications/allure-results/ ];then
  echo move applications test files.
  mv ../../applications/allure-results/*.json $AGGREGATE_DIR/.
fi

# interfacesのallureレポートを収集する
if [ -d ../../interfaces/allure-results/ ];then
  echo move interfaces test files.
  mv ../../interfaces/allure-results/*.json $AGGREGATE_DIR/.
fi
