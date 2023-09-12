#!/bin/bash

# Check if csv file is provided
if [[ -z "$1" ]]; then
	echo "Usage: $0 <path-to-csv-file>"
	exit 1
fi

# Read CSV line by line
{
	# Skip the header
	read

	while IFS=, read -r text; do
		echo "#####################"
		echo "SAVING TEXT"
		echo $text
		# Make curl request to localhost:8080/save
		curl -X POST "http://localhost:8080/save" \
			-H "Content-Type: application/json" \
			-d '{"text":"$text"}'
		echo "#####################"
	done
} <"$1"
