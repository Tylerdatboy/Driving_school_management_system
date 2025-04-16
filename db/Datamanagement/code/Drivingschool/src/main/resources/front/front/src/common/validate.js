export default {
    isEmail2: function (s) {
          return /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(s)
    },
  isEmail: function (rule, value, callback) {
    let reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter 正确的邮箱'));
    } else {
      callback()
    }
  },
  isEmailNotNull: function (rule, value, callback) {
    let reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter 正确的邮箱'));
    }else if (!value) {
      callback(new Error('Enter 邮箱'));
    } else {
      callback()
    }
  },
  isMobile2: function (s) {
        return /^1[0-9]{10}$/.test(s);
  },
  isMobile: function (rule, value, callback) {
    let reg = /^1[0-9]{10}$/;
    if (value && reg.test(value) === false) {
      callback(new Error('Please enter the correct phone number'));
    } else {
      callback()
    }
  },
  isMobileNotNull: function (rule, value, callback) {
    let reg = /^1[0-9]{10}$/;
    if (value && reg.test(value) === false) {
      callback(new Error('Please enter the correct phone number'));
    } else if(!value){
      callback(new Error('Enter 手机号码'));
    } else {
      callback()
    }
  },
  isPhone: function (rule, value, callback) {
    let reg = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
    if (value && reg.test(value) === false) {
      callback(new Error('Please enter the correct phone number'));
    } else {
      callback()
    }
  },
  isPhoneNotNull: function (rule, value, callback) {
    let reg = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
    if (value && reg.test(value) === false) {
      callback(new Error('Please enter the correct phone number'));
    } else if(!value) {
      callback(new Error('Enter 电话号码'));
    } else {
      callback()
    }
  },
  isURL: function (rule, value, callback) {
    let reg = /^http[s]?:\/\/.*/;
    if (value && reg.test(value) === false) {
      callback(new Error('Please enter the correct URL address'));
    } else {
      callback()
    }
  },
  isURLNotNull: function (rule, value, callback) {
    let reg = /^http[s]?:\/\/.*/;
    if (value && reg.test(value) === false) {
      callback(new Error('Please enter the correct URL address'));
    } else if(!value) {
      callback(new Error('Enter 地址'));
    } else {
      callback()
    }
  },
  isNumber: function (rule, value, callback) {
    let reg = /(^-?[+-]?([0-9]*\.?[0-9]+|[0-9]+\.?[0-9]*)([eE][+-]?[0-9]+)?$)|(^$)/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter 正确的数字'));
    } else {
      callback()
    }
  },
  isNumberNotNull: function (rule, value, callback) {
    let reg = /(^-?[+-]?([0-9]*\.?[0-9]+|[0-9]+\.?[0-9]*)([eE][+-]?[0-9]+)?$)|(^$)/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter 正确的数字'));
    } else if(!value) {
      callback(new Error('Please enter a number'));
    } else {
      callback()
    }
  },
  isIntNumer: function (rule, value, callback) {
    let reg = /(^-?\d+$)|(^$)/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter 正确的整数'));
    } else {
      callback()
    }
  },
  isIntNumerNotNull: function (rule, value, callback) {
    let reg = /(^-?\d+$)|(^$)/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter 正确的整数'));
    } else if(!value) {
      callback(new Error('Please enter an integer'));
    } else {
      callback()
    }
  },
  isIdCard: function (rule, value, callback) {
    let reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter Correct ID'));
    } else {
      callback()
    }
  },
  isIdCardNotNull: function (rule, value, callback) {
    let reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    if (value && reg.test(value) === false) {
      callback(new Error('Enter Correct ID'));
    } else if(!value) {
      callback(new Error('Enter ID'));
    } else {
      callback()
    }
  }
}
