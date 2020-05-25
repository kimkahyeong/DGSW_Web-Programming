function loginBefore () {
    document.getElementById('loginBox').style.display = 'none';
    
    ('#signInEmail').val('');
    ('#signInPassword').val('');
  }

  function loginAfter () {
    document.getElementById('loginBox').style.display = 'flex';
  }