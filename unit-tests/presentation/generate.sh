
mkdir -p generated

#Export as html5
docker run --rm -v $(pwd):/documents -e "FORMAT=revealjs-sqli" -e "CSS=online" -e "THEME=SQLI" \
    registry-private.docker.iscbordeaux.lan.bdx.sqli.com/sqli/asciidoctor unit-tests-course.adoc
    
mv SLIDE_REVEALJS_SQLI_unit-tests-course.html generated/

#Export as pdf
docker run --name export_to_pdf --rm -v "${PWD}":/documents/ asciidoctor/docker-asciidoctor:latest \
  asciidoctor-pdf unit-tests-course.adoc

mv unit-tests-course.pdf generated/SLIDE_PDF_SQLI_unit-tests-course.pdf