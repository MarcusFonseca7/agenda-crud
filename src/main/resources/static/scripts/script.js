// Váriaveis para validação da criação de clientes
const form = document.querySelector("#form-client");
const nameInput = document.querySelector("#name");
const cpfInput = document.querySelector("#cpf");
const dateBirthInput = document.querySelector("#dateBirth");

// Váriaveis para validação da criação e edição de contatos
const formCreateEdit = document.querySelector("#form-create-edit");
const typeContactInput = document.querySelector("#typeContact");
const valueContactInput = document.querySelector("#valueContact");
const obsInput = document.querySelector("#obs");

// console.log(form, nameInput, cpfInput, dateBirthInput, cepInput, addressInput, numberInput, complementoInput)

console.log(formCreateEdit, typeContactInput, valueContactInput, obsInput);


//validações para a criação de clientes
form.addEventListener("submit", (event) => {
  event.preventDefault();

  if (nameInput.value === "" || !isNameValid(nameInput.value)) {
    alert("Por favor digite seu nome.");
    return;
  }

  if (
    cpfInput.value === "" ||
    isCpfValid(cpfInput.value) ||
    cpfInput.value.length != 11
  ) {
    alert("Por favor digite seu CPF.");
    cpfInput.value = cpfInput.value.slice(0, 11);
    return;
  }

  if (!isDateBirthValid(dateBirthInput.value)) {
    alert("Por favor digite corretamente sua data de nascimento.");
    return;
  }

  form.submit();
});

function isNameValid(name) {
  const nameRegex = new RegExp(/[0-9]/); //validação para não existir números no nome

  if (nameRegex.test(name)) {
    return false; //se existir, retorna falso, e então o alerta é ativado
  }

  return true; //se não existir, retorna true e o nome é válido
}

function isCpfValid(cpf) {
  const cpfRegex = new RegExp("[0-9]{11}"); //validação para não existir letras no cpf

  if (cpfRegex.test(cpf)) {
    return false; //se existir, retorna falso, e então o alerta é ativado
  }

  return true; //se não existir, retorna true e o cpf é válido
}

function isDateBirthValid(dateBirth) {
  let birthYear = new Date(dateBirthInput.value).getFullYear();
  let actualYear = new Date().getFullYear();

  if (birthYear > actualYear || birthYear < 1900 || dateBirth === "") {
    return false;
  }
  return true;
}

// validações para a criação de contatos

formCreateEdit.addEventListener("submit", (event) => {
  event.preventDefault();

  if (typeContactInput.value != "Email" && typeContactInput.value != "Telefone") {
    alert("Por favor, digite o tipo do contato como 'Email' ou 'Telefone'.");
    return;
  }

  if (
    valueContactInput.value === "" ) {
    alert("Por favor, digite o valor do seu contato.");
    return;
  }

  if (obsInput.value === "") {
    alert("Por favor, digite uma observação.");
    return;
  }

  formCreateEdit.submit();
});


