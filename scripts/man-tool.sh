#!/bin/bash

TOOL_PATH="../management-tool"
mkdir -p "$TOOL_PATH"
cd "$TOOL_PATH" || exit

git clone https://github.com/problemfighter/opensource-management-tools.git tools
git clone https://github.com/problemfighter/opensource-doc-html.git documentation
git clone https://github.com/problemfighter/opensource-doc-adoc.git raw-doc
