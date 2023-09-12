# Check if csv file is provided
if (-not $args[0]) {
    Write-Host "Usage: $($MyInvocation.MyCommand.Name) <path-to-csv-file>"
    exit 1
}

# Skip the header
$csvLines = Get-Content -Path $args[0] | Select-Object -Skip 1

# Read CSV line by line
foreach ($line in $csvLines) {
    Write-Host "#####################"
    Write-Host "SAVING TEXT"
    Write-Host $line

    # Make curl request to localhost:8080/save
    $json = @{
        text = $line
    } | ConvertTo-Json

    Invoke-RestMethod -Uri "http://localhost:8080/save" -Method Post -ContentType "application/json" -Body $json

    Write-Host "#####################"
}

