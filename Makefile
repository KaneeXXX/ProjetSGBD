rapport:
	java -jar ./bin/plantuml-1.2023.12.jar -tlatex schema.txt
	xelatex -shell-escape rapport.tex

schema:
	java -jar ./bin/plantuml-1.2023.12.jar schema.txt
