@echo off
if exist out rmdir /s /q out
mkdir out
for /R %%f in (*.java) do (
    echo Compiling %%f
    javac -d out "%%f"
)
echo Compilation finished.
