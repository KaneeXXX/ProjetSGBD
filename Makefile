rapport:
	java -jar ./bin/plantuml-1.2023.12.jar -tsvg schema.txt
	pdflatex -shell-escape rapport.tex

schema:
	java -jar ./bin/plantuml-1.2023.12.jar schema.txt
