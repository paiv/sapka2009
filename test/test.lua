function can_step_on(icon)
  return (icon == '.' or icon == 'b' or icon == 'v' or icon == 'f' or
    icon == '?')
end

f = can_step_on('.')
print(f)
