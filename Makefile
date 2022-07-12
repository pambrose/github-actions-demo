default: versioncheck

clean:
	./gradlew clean

compile: build

build:
	./gradlew build -xtest

tests:
	./gradlew --rerun-tasks check

yaml:
	.github/workflows/makefile_workflow.main.kts > .github/workflows/makefile_workflow.yaml

versioncheck:
	./gradlew dependencyUpdates

upgrade-wrapper:
	./gradlew wrapper --gradle-version=7.5-rc-5 --distribution-type=bin