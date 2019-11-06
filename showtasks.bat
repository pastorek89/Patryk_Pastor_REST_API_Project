call runcrud.bat
if %ERRORLEVEL% == 0 goto browserOpen
echo Errors occured!
goto end

:browserOpen
start "" "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" http://localhost:8080/crud/v1/task/getTasks
goto end

:end
echo job finished!