# eventos
### repositório para o trabalho da discilplina de Desenvolvimento de Aplicações Corporativas
### Desenvolvido em Spring Boot

_Esta API foi documentada com o swagger, mas abaixo
é possível visualizar os endpoint disponíveis._

## Volume
**GET** `/volumes` ➝ todos os volumes
</br>
**GET** `/volumes/{id}` ➝ recuperar um volume específico
</br>
**POST** `/volumes` ➝ criação de volume
</br>
**PUT** `/volumes/{id}` ➝ atualizar volume
</br>
**DELETE** `/volumes/{id}` ➝ excluir volume
</br>
**GET** `/volumes/{id}/artigos` ➝ artigos de um volume

## Artigo
**GET** `/artigos` ➝ todos os artigos
</br>
**GET** `/artigos/{id}` ➝ recuperar um artigo específico
</br>
**POST** `/artigos` ➝ criação de artigo
</br>
**PUT** `/artigos/{id}` ➝ atualizar artigo
</br>
**DELETE** `/artigos/{id}` ➝ excluir artigo
</br>
**GET** `/artigos/{id}/autores` ➝ autores de um artigo

## Autor
**GET** `/autores` ➝ todos os autores
</br>
**GET** `/autores/{id}` ➝ recuperar um autor específico
</br>
**POST** `/autores` ➝ criação de autor
</br>
**PUT** `/autores/{id}` ➝ atualizar autor
</br>
**DELETE** `/autores/{id}` ➝ excluir autor
</br>
