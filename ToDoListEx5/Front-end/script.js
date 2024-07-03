document.addEventListener('DOMContentLoaded', function () {
   const addTaskButton = document.getElementById('add-task');
   const deleteTaskButton = document.getElementById('delete-task');
   const editTaskButton = document.getElementById('edit-task');
   const popupBackground = document.querySelector('.popup-background');
   const closeButton = document.querySelector('.close-button');
   const saveButton = document.querySelector('.save-button');
   const popupContainer = document.querySelector('.popup-container');
   let selectedTask = null;

   addTaskButton.addEventListener('click', function () {
       popupBackground.style.display = 'block';
       clearPopupFields();
       selectedTask = null;  
   });
   closeButton.addEventListener('click', function () {
       popupBackground.style.display = 'none';
   });

   saveButton.addEventListener('click', function () {
    const title = popupContainer.querySelector('.title').innerText.trim();
    const description = popupContainer.querySelector('.text').innerText.trim();

    if (title === '' || description === '') {
        alert('Preencha o título e a descrição da tarefa.');
        return;
    }

    if (selectedTask) {
        selectedTask.querySelector('.title').innerText = title;
        selectedTask.querySelector('.text').innerText = description;
    } else {
        const newTask = createTask(title, description);
        document.querySelector('.kanban.To-do').appendChild(newTask);
    }

    popupBackground.style.display = 'none';
});

   document.addEventListener('click', function (event) {
       if (event.target.closest('.dd-item')) {
           if (selectedTask) {
               selectedTask.classList.remove('selected');
           }
           selectedTask = event.target.closest('.dd-item');
           selectedTask.classList.add('selected');
       }
   });

   deleteTaskButton.addEventListener('click', function () {
       if (selectedTask) {
           selectedTask.remove();
           selectedTask = null;
       } else {
           alert('Selecione uma tarefa para apagar.');
       }
   });

   editTaskButton.addEventListener('click', function () {
       if (selectedTask) {
           loadTaskToPopup(selectedTask);
           popupBackground.style.display = 'block';
       } else {
           alert('Selecione uma tarefa para editar.');
       }
   });

   function createTask(title, description) {
    const task = document.createElement('li');
    task.classList.add('dd-item');
    task.setAttribute('data-id', Date.now());

    const taskTitle = document.createElement('h3');
    taskTitle.classList.add('title', 'dd-handle');
    taskTitle.innerText = title;
    taskTitle.setAttribute('contenteditable', 'true');
    task.appendChild(taskTitle);

    const taskDescription = document.createElement('div');
    taskDescription.classList.add('text');
    taskDescription.innerText = description;
    taskDescription.setAttribute('contenteditable', 'true');
    task.appendChild(taskDescription);

    const label = document.createElement('i');
    label.classList.add('material-icons');
    label.setAttribute('id', 'label blue');
    task.appendChild(label);

    const actions = document.createElement('div');
    actions.classList.add('actions');
    actions.innerHTML = `
        <label for="file-input-${task.getAttribute('data-id')}">
            <i class="material-icons">attach_file</i>
        </label>
        <input id="file-input-${task.getAttribute('data-id')}" type="file" style="display: none;">
    `;
    task.appendChild(actions);

    return task;
}

   function clearPopupFields() {
       popupContainer.querySelector('.title').innerText = 'Título';
       popupContainer.querySelector('.text').innerText = 'Descrição da tarefa';
   }

   function loadTaskToPopup(task) {
       const title = task.querySelector('.title').innerText;
       const description = task.querySelector('.text').innerText;

       popupContainer.querySelector('.title').innerText = title;
       popupContainer.querySelector('.text').innerText = description;
   }
});



document.addEventListener('DOMContentLoaded', function() {
    const emailPopup = document.querySelector('.popup-background-email');
    const notificationButton = document.getElementById('notification');
    const closeButton = document.querySelector('.close-button');
    const submitButton = document.getElementById('submit-email');

    // Exibir popup ao clicar no botão de notificação
    notificationButton.addEventListener('click', () => {
        emailPopup.style.display = 'flex';
    });

    // Fechar popup ao clicar no botão Fechar
    closeButton.addEventListener('click', () => {
        emailPopup.style.display = 'none';
    });

    // Lidar com a inscrição por email
    submitButton.addEventListener('click', () => {
        const emailInput = document.querySelector('.kanban.Email .text').textContent;
        
        // Aqui você pode enviar o email para onde desejar, por exemplo, via AJAX
        console.log(`Email inscrito: ${emailInput}`);

        // Fechar o popup após inscrição
        emailPopup.style.display = 'none';

        // Opcional: Limpar o campo de email após inscrição
        document.querySelector('.kanban.Email .text').textContent = 'Coloque aqui seu email';
    });
});
