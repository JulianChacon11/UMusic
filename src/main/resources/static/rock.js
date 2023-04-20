const btnReaccion=document.getElementById('reaccion');

btnReaccion.addEventListener('click', like);
let estado=0;
function like(){
  if (estado===0){
    btnReaccion.classList.add('reaccion-activa');
    estado=1;
  }else if(estado===1){
    btnReaccion.classList.remove('reaccion-activa');
    estado===0;
  }
}
const contenedorListaMusic=document.getElementById('lista-music');
const controles=document.getElementById('controles');

const menuMusic=document.getElementById('menuMusic');
const titlePlaylist=document.getElementById('titlePlaylist');
const playDescription=document.getElementById('playDescription');
const imgAlbum=document.getElementById('imgAlbum');
const album=document.getElementById('album');
