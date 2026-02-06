
OUTPUT=$(PWD)/target

all: test lib

.PHONY: test
test:
	lein test

$(OUTPUT)/lib.jar:
	lein jar
	cp target/mui-reagent-*.jar $@

$(OUTPUT)/pom.xml:
	lein pom
	cp pom.xml $@

lib: $(OUTPUT)/lib.jar $(OUTPUT)/pom.xml

clean:
	lein clean
