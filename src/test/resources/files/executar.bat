
cd C:\\repositorio_local\\Mobile

mvn -DskipTests -P prepare-for-upload package && appcenter test run appium --app "bpastorelli/appCenter" --devices "bpastorelli/samsunga7" --app-path .\Mobile\src\test\resources\apk\ml.apk --test-series "master" --locale "en_US" --build-dir target/upload