const BASE_URL= 'http://localhost:8080/backend';

function writeOutput(data){
    const out = document.getElementById('output');
    if(typeof data === 'string'){
        out.textContent = data;
    } else {
        out.textContent = JSON.stringify(data, null, 2);
    }
}

function clearInputs(){
    document.getElementById('entryId').value = '';
    document.getElementById('entryTitle').value = '';
    document.getElementById('entryContent').value = '';
}

async function getEntry(){
    const id = document.getElementById('entryId').value;
    clearInputs();
    if(!id){
        writeOutput("Entry ID is required");
    }
    const response = await fetch(`${BASE_URL}/id/${id}`,{method:'GET'});
    if(response == null){
        writeOutput("No data found");
    }
    const result = await response.json();
    writeOutput(result);
}

async function getALLEntries(){
    clearInputs();
    const response = await fetch(`${BASE_URL}`, {method: 'GET'});
    if(response == null){
        writeOutput("No Entries found");
    }
    const result = await response.json();
    writeOutput(result);
}

async function createEntry(){
    const id = document.getElementById('entryId').value;
    const title = document.getElementById('entryTitle').value;
    const content = document.getElementById('entryContent').value;
    clearInputs();
    
    if(!id || !title || !content){
        writeOutput("Please give a valid input");
    }
    const payload = {id,title,content};
    const response = await fetch(`${BASE_URL}`,{method:'POST' , headers : {'Content-Type': 'application/json'} , body: JSON.stringify(payload)});
    if(response == null){
        writeOutput("Entry not created");
    }
    else{
        writeOutput(await response.json());
    }
}

async function updateEntry(){
    const id = document.getElementById('entryId').value;
    const title = document.getElementById('entryTitle').value;
    const content = document.getElementById('entryContent').value;
    clearInputs();
    const payload = {title, content};
    const response = await fetch(`${BASE_URL}/id/${id}`, {method: 'PUT', headers : {'Content-Type': 'application/json'} , body: JSON.stringify(payload)})
    if(response == null){
        writeOutput("Cannot update id: ", id);
    }
    else{
        writeOutput(await response.json());
    }
}

async function deleteEntry(){
    clearInputs();
    const id = document.getElementById('entryId').value;
    if(!id){
        writeOutput("Please Enter an ID");
    }
    const response = await fetch(`${BASE_URL}/id/${id}`, {method: 'DELETE'});
        writeOutput("Entry deleted by id: " +id + "Resposne " +response);

}